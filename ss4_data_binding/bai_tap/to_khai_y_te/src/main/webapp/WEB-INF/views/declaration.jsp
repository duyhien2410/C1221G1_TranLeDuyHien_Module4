
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/5/2022
  Time: 5:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <h3>TỜ KHAI Y TẾ</h3>
    <h4>ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN CỦA ANH/CHỊ SẼ GIÚP CƠ QUAN Y TẾ LIÊN LẠC KHI CẦN THIẾT ĐỂ PHÒNG CHỐNG DỊCH BỆNH TRUYỀN NHIỄM</h4>
    <h5>Khuyến cáo: Khai báo thông tin sai là vi phạm pháp luật Việt Nam và có thể xử lý hình sự</h5>
</center>

<form:form action="" modelAttribute="declaration" method="post">
    <div>
        <p>Họ tên (ghi chữ IN HOA) (*)</p>
        <form:input path="name"/>
    </div>
    <div>
        <p>Năm sinh (*)</p>
        <form:input type="date" path="dayOfBirth"/>
    </div>
    <div>
        <p>Giới tính (*)</p>
        <form:select path="gender">
            <form:option value="Nam"/>Nam
            <form:option value="Nữ"/>Nữ
        </form:select>
    </div>
    <div>
        <p>Quốc tịch (*)</p>
        <form:input path="nationality"/>
    </div>
    <div>
        <p>Số hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khác (*)</p>
        <form:input path="idCard"/>
    </div>
    <div>
        <p>Thông tin đi lại (*)</p>
        <form:radiobutton path="vehicle" value="Tàu bay"/> Tàu bay
        <form:radiobutton path="vehicle" value="Tàu thuyền"/> Tàu thuyền
        <form:radiobutton path="vehicle" value="Ô tô"/> Ô tô
        <form:radiobutton path="vehicle" value="Khác"/> Khác (Ghi rõ)
    </div>
    <div>
        <p>Số hiệu phương tiện</p>
        <form:input path="codeVehicle"/>
    </div>
    <div>
        <p>Số ghế</p>
        <form:input path="seats"/>
    </div>
    <div>
        <p>Ngày khởi hành (*)</p>
        <form:input type="date" path="startDay"/>
    </div>
    <div>
        <p>Ngày kết thúc (*)</p>
        <form:input type="date" path="endDay"/>
    </div>
    <div>
        <p>Trong vòng 14 ngày qua, Anh/Chị có đến tỉnh/thành phố nào? (*)</p>
        <form:textarea path="passingPlace"/>
    </div>
</form:form>
<center>
    <h5>Dữ liệu bạn cung cấp hoàn toàn bảo mật và chỉ phục vụ cho việc phòng chống dịch, thuộc quản lý của Ban chỉ đạo quốc gia về Phòng chống dịch Covid-19. Khi bạn nhấn nút "Gửi" là bạn đã hiểu và đồng ý.</h5>
    <input type="submit" value="GỬI TỜ KHAI">
</center>
</body>
</html>
