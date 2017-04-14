var Script = function () {



    var barChartData = {
        labels : ["1月","2月","3月","4月","5月","6月","7月","8月","9月","10月","11月","12月"],
        datasets : [
            {
                fillColor : "#9900FF",
                strokeColor : "#9900FF",
                data :str2
                    //[180,175,180,185,195,180,195,185,185,190,180,185]
            },
            {
                fillColor : "#33CC00",
                strokeColor : "#33CC00",
                data : str1
                    //[185,180,185,190,196,195,200,189,190,195,0,0]
            }
        ]

    };
   
    new Chart(document.getElementById("bar").getContext("2d")).Bar(barChartData);


}();