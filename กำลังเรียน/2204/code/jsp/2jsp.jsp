<%--
    Document   : showDataDB
    Created on : Sep 5, 2024, 1:09:03 PM
    Author     : chouv
--%>

<%@page import="java.sql.*"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Resume Database</title>

    <style>

        /* ================================
           GLOBAL
           ================================ */

        * {
            box-sizing: border-box;
            margin: 0;
            padding: 0;
        }

        body {
            font-family: Arial, Helvetica, sans-serif;
            background: #f4f6f8;
            color: #333;
            line-height: 1.6;
        }

        /* ================================
           HEADER
           ================================ */

        .header {
            background: #1f2937;
            color: white;
            padding: 25px 20px;
            text-align: center;
            box-shadow: 0 2px 8px rgba(0,0,0,0.15);
        }

        .header h1 {
            font-size: 28px;
            margin-bottom: 5px;
        }

        .header p {
            color: #d1d5db;
            font-size: 14px;
        }

        /* ================================
           CONTAINER
           ================================ */

        .container {
            width: 90%;
            max-width: 1200px;
            margin: 30px auto;
        }

        /* ================================
           CARD
           ================================ */

        .card {
            background: white;
            border-radius: 12px;
            padding: 25px;
            box-shadow: 0 4px 15px rgba(0,0,0,0.08);
        }

        .card-header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 20px;
            gap: 20px;
        }

        .card-title {
            font-size: 22px;
            font-weight: bold;
            color: #1f2937;
        }

        /* ================================
           SEARCH
           ================================ */

        .search-box {
            display: flex;
            gap: 10px;
        }

        .search-box input {
            width: 280px;
            padding: 11px 15px;
            border: 1px solid #d1d5db;
            border-radius: 7px;
            font-size: 14px;
            outline: none;
            transition: 0.3s;
        }

        .search-box input:focus {
            border-color: #2563eb;
            box-shadow: 0 0 0 3px rgba(37,99,235,0.1);
        }

        /* ================================
           TABLE
           ================================ */

        .table-container {
            width: 100%;
            overflow-x: auto;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 10px;
        }

        thead {
            background: #1f2937;
            color: white;
        }

        th,
        td {
            padding: 14px 16px;
            text-align: left;
            border-bottom: 1px solid #e5e7eb;
        }

        th {
            font-size: 14px;
            text-transform: uppercase;
            letter-spacing: 0.5px;
        }

        td {
            font-size: 15px;
        }

        tbody tr {
            transition: 0.2s;
        }

        tbody tr:hover {
            background: #f3f4f6;
        }

        /* ================================
           ID
           ================================ */

        .id-column {
            width: 80px;
            text-align: center;
            font-weight: bold;
        }

        /* ================================
           BADGE
           ================================ */

        .badge {
            display: inline-block;
            padding: 5px 10px;
            border-radius: 20px;
            background: #e5e7eb;
            color: #374151;
            font-size: 12px;
            font-weight: bold;
        }

        /* ================================
           FOOTER
           ================================ */

        .table-footer {
            margin-top: 15px;
            display: flex;
            justify-content: space-between;
            align-items: center;
            color: #6b7280;
            font-size: 14px;
        }

        /* ================================
           BUTTON
           ================================ */

        .btn {
            border: none;
            padding: 10px 18px;
            border-radius: 7px;
            cursor: pointer;
            font-size: 14px;
            background: #2563eb;
            color: white;
            transition: 0.2s;
        }

        .btn:hover {
            background: #1d4ed8;
        }

        /* ================================
           ERROR
           ================================ */

        .error {
            background: #fee2e2;
            color: #991b1b;
            padding: 15px;
            border-radius: 8px;
            margin-bottom: 20px;
            border-left: 5px solid #dc2626;
        }

        /* ================================
           RESPONSIVE
           ================================ */

        @media (max-width: 768px) {

            .container {
                width: 95%;
                margin: 20px auto;
            }

            .card {
                padding: 15px;
            }

            .card-header {
                flex-direction: column;
                align-items: stretch;
            }

            .search-box input {
                width: 100%;
            }

            th,
            td {
                padding: 10px;
            }

            .header h1 {
                font-size: 22px;
            }

        }

    </style>
</head>

<body>

    <!-- ================================
         HEADER
         ================================ -->

    <header class="header">

        <h1>Resume Database</h1>

        <p>Personal Resume Information Management</p>

    </header>


    <!-- ================================
         MAIN CONTAINER
         ================================ -->

    <main class="container">

        <div class="card">

            <div class="card-header">

                <div class="card-title">
                    Resume Information
                </div>

                <div class="search-box">

                    <input
                        type="text"
                        id="searchInput"
                        placeholder="Search name, surname, address..."
                        onkeyup="searchTable()"
                    >

                </div>

            </div>


            <!-- ================================
                 DATABASE TABLE
                 ================================ -->

            <div class="table-container">

                <table id="resumeTable">

                    <thead>

                        <tr>

                            <th class="id-column">
                                ID
                            </th>

                            <th>
                                Name
                            </th>

                            <th>
                                Surname
                            </th>

                            <th>
                                Address
                            </th>

                        </tr>

                    </thead>

                    <tbody>

                        <%
                            int recordCount = 0;

                            try {

                                Class.forName("org.mariadb.jdbc.Driver");

                                String url =
                                    "jdbc:mariadb://localhost:3306/test"
                                    + "?sslMode=disable";

                                String username = "root";
                                String password = "1234";

                                String sql =
                                    "SELECT Id, Name, Surname, Address "
                                    + "FROM Resume";

                                try (
                                    Connection c =
                                        DriverManager.getConnection(
                                            url,
                                            username,
                                            password
                                        );

                                    PreparedStatement ps =
                                        c.prepareStatement(sql);

                                    ResultSet r =
                                        ps.executeQuery()
                                ) {

                                    while (r.next()) {

                                        recordCount++;
                        %>

                        <tr>

                            <td class="id-column">
                                <span class="badge">
                                    <%= r.getString("Id") %>
                                </span>
                            </td>

                            <td>
                                <%= r.getString("Name") %>
                            </td>

                            <td>
                                <%= r.getString("Surname") %>
                            </td>

                            <td>
                                <%= r.getString("Address") %>
                            </td>

                        </tr>

                        <%
                                    }

                                }

                            } catch (Exception e) {
                        %>

                        <tr>

                            <td colspan="4">

                                <div class="error">

                                    Database Error:
                                    <%= e.getMessage() %>

                                </div>

                            </td>

                        </tr>

                        <%
                            }
                        %>

                    </tbody>

                </table>

            </div>


            <!-- ================================
                 TABLE FOOTER
                 ================================ -->

            <div class="table-footer">

                <div>

                    Total Records:
                    <strong id="recordCount">
                        <%= recordCount %>
                    </strong>

                </div>

                <button
                    class="btn"
                    onclick="clearSearch()">

                    Clear Search

                </button>

            </div>

        </div>

    </main>


    <!-- ================================
         JAVASCRIPT
         ================================ -->

    <script>

        /*
         * Search data in table
         */
        function searchTable() {

            let input =
                document.getElementById("searchInput");

            let filter =
                input.value.toLowerCase();

            let table =
                document.getElementById("resumeTable");

            let rows =
                table.getElementsByTagName("tbody")[0]
                     .getElementsByTagName("tr");

            let visibleCount = 0;


            for (let i = 0; i < rows.length; i++) {

                let row =
                    rows[i];

                let text =
                    row.textContent.toLowerCase();


                if (text.indexOf(filter) > -1) {

                    row.style.display = "";

                    visibleCount++;

                } else {

                    row.style.display = "none";

                }

            }


            /*
             * Update visible record count
             */
            document.getElementById("recordCount")
                    .textContent = visibleCount;

        }


        /*
         * Clear search
         */
        function clearSearch() {

            document.getElementById("searchInput")
                    .value = "";

            searchTable();

            document.getElementById("searchInput")
                    .focus();

        }

    </script>

</body>

</html>