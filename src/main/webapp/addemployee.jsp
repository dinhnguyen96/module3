<%--
  Created by IntelliJ IDEA.
  User: Nam
  Date: 3/13/2023
  Time: 8:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create new employee</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <style>
        * {
            font-family: 'Roboto', sans-serif;
        }

        body {
            color: #000;
            overflow-x: hidden;
            height: 100%;
            background-image: url("https://i.imgur.com/GMmCQHC.png");
            background-repeat: no-repeat;
            background-size: 100% 100%
        }

        .card {
            padding: 30px 40px;
            margin-top: 60px;
            margin-bottom: 60px;
            border: none !important;
            box-shadow: 0 6px 12px 0 rgba(0, 0, 0, 0.2)
        }

        .blue-text {
            color: #00BCD4
        }

        .form-control-label {
            margin-bottom: 0
        }

        input, textarea, button {
            padding: 8px 15px;
            border-radius: 5px !important;
            margin: 5px 0px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            font-size: 18px !important;
            font-weight: 300
        }

        input:focus, textarea:focus {
            -moz-box-shadow: none !important;
            -webkit-box-shadow: none !important;
            box-shadow: none !important;
            border: 1px solid #00BCD4;
            outline-width: 0;
            font-weight: 400
        }

        .btn-block {
            text-transform: uppercase;
            font-size: 15px !important;
            font-weight: 400;
            height: 43px;
            cursor: pointer
        }

        .btn-block:hover {
            color: #fff !important
        }

        button:focus {
            -moz-box-shadow: none !important;
            -webkit-box-shadow: none !important;
            box-shadow: none !important;
            outline-width: 0
        }
        .btn-primary {
            color: #fff;
            background-color: #007bff;
            border-color: #007bff;
            border-radius: 5px;
            margin-top: 1px;
        }
    </style>
</head>
<body>
<div class="container-fluid px-1 py-5 mx-auto">
    <div class="row d-flex justify-content-center">
        <div class="col-xl-7 col-lg-8 col-md-9 col-11 text-center">
            <h2>THÊM NHÂN VIÊN</h2>
            <div class="card">
                <form method="post" class="form-card">
                    <div class="row justify-content-between text-left">
                        <div class="form-group col-sm-6 flex-column d-flex"><label class="form-control-label px-3">Mã nhân viên<span
                                class="text-danger"> *</span></label>
                            <input type="text" id="code" name="employeeCode" placeholder="Mã nhân viên..." ">
                        </div>
                        <div class="form-group col-sm-6 flex-column d-flex"><label class="form-control-label px-3">Tên nhân viên
                            <span class="text-danger"> *</span></label> <input type="text"  name="employeeName"
                                                                               placeholder="Tên nhân viên...""></div>
                    </div>
                    <div class="row justify-content-between text-left">
                        <div class="form-group col-sm-6 flex-column d-flex"><label class="form-control-label px-3">Địa chỉ
                            <span class="text-danger"> *</span></label> <input type="text" name="employeeAddress"
                                                                               placeholder="Địa chỉ..."><
                            </div>
                        </div>
                        <div class="form-group col-sm-6 flex-column d-flex"><label class="form-control-label px-3">Lương
                            <span class="text-danger"> *</span></label> <input type="number"  name="employeeSalary"
                                                                               placeholder="Lương...">
                        </div>
                    </div>

                    <div class="row justify-content-between text-left">
                        <div class="form-group col-12 flex-column d-flex"><label class="form-control-label px-3">Địa chỉ
                            <span class="text-danger"> *</span></label> <input type="text"
                                                                               id="address"
                                                                               name="address"
                                                                               placeholder="Địa chỉ..."
                                                                               onblur="validate(6)">
                        </div>
                    </div>
            <div class="row justify-content-between text-left">
                <div class="form-group col-12 flex-column d-flex"><label class="form-control-label px-3">
                    <select class="form-select" id="status">
                        <c:forEach items="${departments}" var="department">
                            <option value="${department.id}" >${department.departmentName}</option>
                        </c:forEach>


                    </select>
                </div>
            </div>
            <div class="row justify-content-end">
                <div class="form-group col-sm-6">
                    <input class="btn-block btn-primary" type="submit" value="LƯU">
                </div>
                <div class="form-group col-sm-6">
                    <a style="text-decoration: none; margin: auto 0;line-height: 3;"
                       class="btn-block btn-primary" href="/employees">QUAY LẠI</a>
                </div>
            </div>

                </form>
            </div>
        </div>
    </div>
</div>
<script>
    function validate(val) {
        v1 = document.getElementById("code");
        v2 = document.getElementById("name");
        v3 = document.getElementById("date");
        v4 = document.getElementById("address");
        v5 = document.getElementById("email");
        v6 = document.getElementById("phone");

        flag1 = true;
        flag2 = true;
        flag3 = true;
        flag4 = true;
        flag5 = true;
        flag6 = true;

        if (val >= 1 || val == 0) {
            if (v1.value == "") {
                v1.style.borderColor = "red";
                flag1 = false;
            } else {
                v1.style.borderColor = "green";
                flag1 = true;
            }
        }

        if (val >= 2 || val == 0) {
            if (v2.value == "") {
                v2.style.borderColor = "red";
                flag2 = false;
            } else {
                v2.style.borderColor = "green";
                flag2 = true;
            }
        }
        if (val >= 3 || val == 0) {
            if (v3.value == "") {
                v3.style.borderColor = "red";
                flag3 = false;
            } else {
                v3.style.borderColor = "green";
                flag3 = true;
            }
        }
        if (val >= 4 || val == 0) {
            if (v4.value == "") {
                v4.style.borderColor = "red";
                flag4 = false;
            } else {
                v4.style.borderColor = "green";
                flag4 = true;
            }
        }
        if (val >= 5 || val == 0) {
            if (v5.value == "") {
                v5.style.borderColor = "red";
                flag5 = false;
            } else {
                v5.style.borderColor = "green";
                flag5 = true;
            }
        }
        if (val >= 6 || val == 0) {
            if (v6.value == "") {
                v6.style.borderColor = "red";
                flag6 = false;
            } else {
                v6.style.borderColor = "green";
                flag6 = true;
            }
        }

        flag = flag1 && flag2 && flag3 && flag4 && flag5 && flag6;

        return flag;
    }
</script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
</body>
</html>
