<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>
<%
	request.setCharacterEncoding("UTF-8");

	// ---- MariaDB connection (ตาราง Resume: Id, Name, Surname, Address) ----
	String dbUrl      = "jdbc:mariadb://localhost:3306/test?sslMode=disable";
	String dbUser     = "root";
	String dbPassword = "1234";

	String action = request.getParameter("action");
	String operationMessage = "";
	boolean operationOk = false;

	try {
		Class.forName("org.mariadb.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		throw new ServletException("ไม่พบ MariaDB JDBC Driver", e);
	}

	// ---- INSERT / UPDATE / DELETE ----
	if (action != null && !"select".equals(action)) {
		try (Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword)) {

			if ("insert".equals(action)) {
				try (PreparedStatement ps = connection.prepareStatement(
						"INSERT INTO Resume (Name, Surname, Address) VALUES (?, ?, ?)")) {
					ps.setString(1, request.getParameter("name"));
					ps.setString(2, request.getParameter("surname"));
					ps.setString(3, request.getParameter("address"));
					ps.executeUpdate();
				}
				operationMessage = "เพิ่มข้อมูลสำเร็จ";
				operationOk = true;

			} else if ("update".equals(action)) {
				try (PreparedStatement ps = connection.prepareStatement(
						"UPDATE Resume SET Name = ?, Surname = ?, Address = ? WHERE Id = ?")) {
					ps.setString(1, request.getParameter("name"));
					ps.setString(2, request.getParameter("surname"));
					ps.setString(3, request.getParameter("address"));
					ps.setInt(4, Integer.parseInt(request.getParameter("id")));
					int n = ps.executeUpdate();
					operationMessage = (n > 0) ? "แก้ไขข้อมูลสำเร็จ" : "ไม่พบ Id ที่ต้องการแก้ไข";
					operationOk = (n > 0);
				}

			} else if ("delete".equals(action)) {
				try (PreparedStatement ps = connection.prepareStatement(
						"DELETE FROM Resume WHERE Id = ?")) {
					ps.setInt(1, Integer.parseInt(request.getParameter("id")));
					int n = ps.executeUpdate();
					operationMessage = (n > 0) ? "ลบข้อมูลสำเร็จ" : "ไม่พบ Id ที่ต้องการลบ";
					operationOk = (n > 0);
				}
			}

		} catch (NumberFormatException e) {
			operationMessage = "Id ต้องเป็นตัวเลข";
		} catch (SQLException e) {
			operationMessage = "ดำเนินการไม่สำเร็จ: " + e.getMessage();
		}
	}
%>
<!DOCTYPE html>
<html lang="th">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Resume CRUD</title>
	<style>
		* { box-sizing: border-box; margin: 0; padding: 0; }
		body { font-family: Arial, Helvetica, sans-serif; background: #f4f6f8; color: #333; line-height: 1.6; }
		.header { background: #1f2937; color: #fff; padding: 22px 20px; text-align: center; }
		.header h1 { font-size: 26px; }
		.container { width: 92%; max-width: 1100px; margin: 26px auto; }
		.card { background: #fff; border-radius: 12px; padding: 22px; box-shadow: 0 4px 15px rgba(0,0,0,.08); margin-bottom: 22px; }
		.card h2 { font-size: 18px; color: #1f2937; margin-bottom: 14px; }
		.msg { padding: 12px 15px; border-radius: 8px; margin-bottom: 18px; font-weight: bold; }
		.msg.ok  { background: #dcfce7; color: #166534; border-left: 5px solid #16a34a; }
		.msg.err { background: #fee2e2; color: #991b1b; border-left: 5px solid #dc2626; }
		.forms { display: grid; grid-template-columns: repeat(auto-fit, minmax(260px, 1fr)); gap: 18px; }
		form { background: #f9fafb; border: 1px solid #e5e7eb; border-radius: 10px; padding: 16px; }
		form h3 { font-size: 15px; margin-bottom: 10px; color: #374151; }
		input { width: 100%; padding: 9px 12px; margin-bottom: 9px; border: 1px solid #d1d5db; border-radius: 7px; font-size: 14px; outline: none; }
		input:focus { border-color: #2563eb; box-shadow: 0 0 0 3px rgba(37,99,235,.12); }
		button { width: 100%; border: none; padding: 10px; border-radius: 7px; cursor: pointer; font-size: 14px; font-weight: bold; color: #fff; }
		.btn-add { background: #16a34a; } .btn-add:hover { background: #15803d; }
		.btn-upd { background: #2563eb; } .btn-upd:hover { background: #1d4ed8; }
		.btn-del { background: #dc2626; } .btn-del:hover { background: #b91c1c; }
		table { width: 100%; border-collapse: collapse; margin-top: 6px; }
		thead { background: #1f2937; color: #fff; }
		th, td { padding: 12px 14px; text-align: left; border-bottom: 1px solid #e5e7eb; font-size: 14px; }
		tbody tr:hover { background: #f3f4f6; }
		.id-col { width: 70px; text-align: center; font-weight: bold; }
	</style>
</head>
<body>
	<header class="header"><h1>Resume — เพิ่ม / แก้ไข / ลบ (CRUD)</h1></header>

	<main class="container">

		<% if (!operationMessage.isEmpty()) { %>
			<div class="msg <%= operationOk ? "ok" : "err" %>"><%= operationMessage %></div>
		<% } %>

		<div class="card">
			<h2>จัดการข้อมูล</h2>
			<div class="forms">

				<form method="post">
					<h3>➕ เพิ่มข้อมูล (INSERT)</h3>
					<input type="hidden" name="action" value="insert">
					<input name="name"    placeholder="Name" required>
					<input name="surname" placeholder="Surname" required>
					<input name="address" placeholder="Address" required>
					<button class="btn-add" type="submit">เพิ่ม</button>
				</form>

				<form method="post">
					<h3>✏️ แก้ไข (UPDATE)</h3>
					<input type="hidden" name="action" value="update">
					<input name="id"      placeholder="Id ที่จะแก้" required>
					<input name="name"    placeholder="Name ใหม่" required>
					<input name="surname" placeholder="Surname ใหม่" required>
					<input name="address" placeholder="Address ใหม่" required>
					<button class="btn-upd" type="submit">แก้ไข</button>
				</form>

				<form method="post" onsubmit="return confirm('ยืนยันลบ Id นี้?');">
					<h3>🗑️ ลบ (DELETE)</h3>
					<input type="hidden" name="action" value="delete">
					<input name="id" placeholder="Id ที่จะลบ" required>
					<button class="btn-del" type="submit">ลบ</button>
				</form>

			</div>
		</div>

		<div class="card">
			<h2>ข้อมูลทั้งหมดในตาราง Resume</h2>
			<table>
				<thead>
					<tr><th class="id-col">Id</th><th>Name</th><th>Surname</th><th>Address</th></tr>
				</thead>
				<tbody>
				<%
					try (Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
						 PreparedStatement ps = connection.prepareStatement(
							 "SELECT Id, Name, Surname, Address FROM Resume ORDER BY Id");
						 ResultSet rs = ps.executeQuery()) {
						while (rs.next()) {
				%>
					<tr>
						<td class="id-col"><%= rs.getInt("Id") %></td>
						<td><%= rs.getString("Name") %></td>
						<td><%= rs.getString("Surname") %></td>
						<td><%= rs.getString("Address") %></td>
					</tr>
				<%
						}
					} catch (SQLException e) {
				%>
					<tr><td colspan="4" style="color:#991b1b;">ไม่สามารถดึงข้อมูลได้: <%= e.getMessage() %></td></tr>
				<%
					}
				%>
				</tbody>
			</table>
		</div>

	</main>
</body>
</html>
