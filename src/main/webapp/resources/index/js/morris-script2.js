var Script = function () {

    //morris chart

    $(function () {
      // data stolen from http://howmanyleft.co.uk/vehicle/jaguar_'e'_type


      Morris.Donut({
        element: 'hero-donut',
        data: [
          {label: '电器产品', value: 20 },
          {label: '信息机电电线电缆', value: 35 },
          {label: '装饰装修材料', value: 25 },
          {label: '食品产品', value: 20 }
        ],
          colors: ['#00FF00','#FF0033','#FFFF00','#CC00FF'],
        formatter: function (y) { return y + "%" }
      });
      $('.code-example').each(function (index, el) {
        eval($(el).text());
      });
    });

}();




