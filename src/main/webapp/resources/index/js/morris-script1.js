var Script = function () {

    //morris chart

    $(function () {
      // data stolen from http://howmanyleft.co.uk/vehicle/jaguar_'e'_type

      Morris.Donut({
        element: 'hero-donut',
        data: 
        	str
        	,
//        	[
//			{label:'业务一科',value:12},{label:'业务二科',value:4},{label:'业务三科',value:4},{label:'业务四科',value:2},{label:'建筑节能业务科',value:2},{label:'电子电器业务科',value:2},{label:'消费品业务科',value:15},{label:'食品化工业务科',value:25},{label:'机械装备业务科',value:17},{label:'节水排灌业务科',value:17}
//        ],
          colors: ['#000080','#CD1076','#EE9A00','#CDCD00','#66FF00','#FF0033','#00CCFF','#FFFF00','#CC00FF','#5FFF00'],
        formatter: function (y) { return y + "%" }
      });
      $('.code-example').each(function (index, el) {
        eval($(el).text());
      });
    });

}();




