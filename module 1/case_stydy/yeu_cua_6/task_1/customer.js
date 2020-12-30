class Customer {
    constructor(name, identityNumber, birthday, email, address, typeCustomer, discount, quantityIncluded, typeRoom, rentDays, typeService) {
        this.name = name;
        this.identityNumber = identityNumber;
        this.birthday = birthday;
        this.email = email;
        this.address = address;
        this.typeCustomer = typeCustomer;
        this.discount = discount;
        this.quantityIncluded = quantityIncluded;
        this.typeRoom = typeRoom;
        this.rentDays = rentDays;
        this.typeService = typeService;
    }
    getName() {
        return this.name;
    }
    getIdentityNumber() {
        return this.identityNumber;
    }
    getBirthday() {
        return this.birthday;
    }
    getEmail() {
        return this.email;
    }
    getAddress() {
        return this.address;
    }
    getTypeCustomer() {
        return this.typeCustomer;
    }
    getDiscount() {
        return this.discount;
    }
    getQuantityIncluded() {
        return this.quantityIncluded;
    }
    getTypeRoom() {
        return this.typeRoom;
    }
    getRentDays() {
        return this.rentDays;
    }
    getTypeService() {
        return this.typeService;
    }
    setName(name) {
        this.name = name;
    }
    setIdentityNumber(identityNumber) {
        this.identityNumber = identityNumber;
    }
    setBirthday(birthday) {
        this.birthday = birthday;
    }
    setEmail(email) {
        this.email = email;
    }
    setAddress(address) {
        return this.address = address;
    }
    setTypeCustomer(typeCustomer) {
        this.typeCustomer = typeCustomer;
    }
    setDiscount(discount) {
        this.discount = discount;
    }
    setQuantityIncluded(quantityIncluded) {
        this.quantityIncluded = quantityIncluded;
    }
    setTypeRoom(typeRoom) {
        this.typeRoom = typeRoom;
    }
    setRentDays(rentDays) {
        this.rentDays = rentDays;
    }
    setTypeService(typeService) {
        this.typeService = typeService;
    }
    totalPays() {
        let money = 0;
        if (this.typeService === "Villa") {
            money = 500;
        } else if (this.typeService === "House") {
            money = 300;
        } else if (this.typeService === "Room") {
            money = 200;
        }
        return this.rentDays * money * (1 - this.discount/100);
    }
}