function submitAbc() {
    console.log("Start");
    // @ts-ignore
    var nameSearch = document.getElementById("search").value;
    var promiseObj = new Promise(function (resolve, reject) {
        var xHttp = new XMLHttpRequest();
        xHttp.onload = function () {
            if (this.status == 200) {
                resolve(xHttp.responseText);
            }
            else {
                reject(xHttp.statusText);
            }
        };
        xHttp.open("GET", 'https://api.github.com/search/repositories?q=' + nameSearch);
        xHttp.send();
    });
    promiseObj.then(function (value) {
        console.log("OK");
        console.log(value);
        if (typeof value === "string") {
            var obj = JSON.parse(value);
            console.log(obj.items);
        }
        // @ts-ignore
        if (typeof value === "string") {
            // @ts-ignore
            document.getElementById("display").innerHTML = value;
        }
        console.log("End");
    }, function (reason) {
        console.log("NG");
        console.log(reason);
    });
}
