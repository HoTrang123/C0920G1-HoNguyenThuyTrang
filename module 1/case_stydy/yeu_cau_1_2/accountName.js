function enter() {
    document.getElementById("create").style.display = "none";
    document.getElementById("show").style.display = "block";
// biến lấy dữ liệu
    let name = document.getElementById("name");
    let cmnd = document.getElementById("cmnd");
    let email = document.getElementById("email");
    let address = document.getElementById("address");
    let cusKind = document.getElementById("cusKind");
    let sale = document.getElementById("sale");
    let num = document.getElementById("num");
    let rent = document.getElementById("rent");
    let serKind = document.getElementById("serKind");
    let room = document.getElementById("room");
// biến xuất dữ liệu
    let name1 = document.getElementById("name1");
    let cmnd1 = document.getElementById("cmnd1");
    let email1 = document.getElementById("email1");
    let address1 = document.getElementById("address1");
    let cusKind1 = document.getElementById("cusKind1");
    let sale1 = document.getElementById("sale1");
    let num1 = document.getElementById("num1");
    let rent1 = document.getElementById("rent1");
    let serKind1 = document.getElementById("serKind1");
    let room1 = document.getElementById("room1");
    let pay = document.getElementById("pay");
    name1.innerText = name.value;
    cmnd1.innerText = cmnd.value;
    email1.innerText = email.value;
    address1.innerText = address.value;
    cusKind1.innerText = cusKind.value;
    sale1.innerText = sale.value;
    num1.innerText = num.value;
    rent1.innerText = rent.value;
    serKind1.innerText = serKind.value;
    room1.innerText = room.value;
//giảm giá theo địa chỉ
    let saleAdd;
    switch (address.value) {
        case "Đà Nẵng":
            saleAdd = 20;
            break;
        case "Huế":
            saleAdd = 10;
            break;
        case "Quảng Nam":
            saleAdd = 5;
            break;
        default:
            saleAdd = 0;
    }
//giảm giá theo số ngày
    let saleRent;
    if (rent.value >7) {
        saleRent = 30;
    } else if (rent.value >5) {
        saleRent = 20;
    } else if (rent.value >2) {
        saleRent = 10;
    } else {
        saleRent = 0;
    }
//giảm giá theo loại khách hàng
    let saleCus;
    switch (cusKind.value) {
        case "Diamond":
            saleCus = 15;
            break;
        case "Platinum":
            saleCus = 10;
            break;
        case "Gold":
            saleCus = 5;
            break;
        case "Silver":
            saleCus = 2;
            break;
        case "Member":
            saleCus = 0;
            break;
    }
    let allGia;
    allGia = saleRent + saleCus + saleAdd;
    let rentD = parseInt(rent.value);
    let outPay;
    switch (serKind.value) {
        case "Villa" :
            outPay = 500 * rentD - allGia;
            break;
        case "House" :
            outPay = 300 * rentD - allGia;
            break;
        case "Room" :
            outPay = 100 * rentD - allGia;
            break;
    }
    pay.innerText = outPay;
}
function edit() {
    document.getElementById("create").style.display = "block";
    document.getElementById("show").style.display = "none";
}