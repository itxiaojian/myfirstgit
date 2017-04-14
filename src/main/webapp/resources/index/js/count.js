function countUp(count)
{
    var div_by = 100,
        speed = Math.round(count / div_by),
        $display = $('.count'),
        run_count = 1,
        int_speed = 24;

    var int = setInterval(function() {
        if(run_count < div_by){
            $display.text(speed * run_count);
            run_count++;
        } else if(parseInt($display.text()) < count) {
            var curr_count = parseInt($display.text()) + 1;
            $display.text(curr_count);
        } else {
            clearInterval(int);
        }
    }, int_speed);
}

countUp(bgzs);

function countUp2(count)
{
    var div_by = 100,
        speed = Math.round(count / div_by),
        $display = $('.count2'),
        run_count = 1,
        int_speed = 24;

    var int = setInterval(function() {
        if(run_count < div_by){
            $display.text(speed * run_count);
            run_count++;
        } else if(parseInt($display.text()) < count) {
            var curr_count = parseInt($display.text()) + 1;
            $display.text(curr_count);
        } else {
            clearInterval(int);
        }
    }, int_speed);
}

countUp2(cbfy);

function countUp3(count)
{
    var div_by = 100,
        speed = Math.round(count / div_by),
        $display = $('.count3'),
        run_count = 1,
        int_speed = 24;

    var int = setInterval(function() {
        if(run_count < div_by){
            $display.text(speed * run_count);
            run_count++;
        } else if(parseInt($display.text()) < Math.round(count)) {
//        	alert(111);
//        	alert(parseInt($display.text()));
//            alert(Math.round($display.text()));
            var curr_count = parseInt($display.text()) + 1;
            $display.text(curr_count);
        } else {
            clearInterval(int);
        }
    }, int_speed);
}

countUp3(bgsf);

function countUp4(count)
{
    var div_by = 100,
        speed = Math.round(count / div_by),
        $display = $('.count4'),
        run_count = 1,
        int_speed = 24;
//    alert(parseInt(count));
//    alert(Math.round(count));

    var int = setInterval(function() {
        if(run_count < div_by){
            $display.text(speed * run_count);
//            alert(111);
//            alert(parseInt($display.text()));
//            alert(Math.round($display.text()));
            run_count++;
        }else if(parseInt($display.text()) < Math.round(count)) {
//        	alert(222);
//        	alert(parseInt($display.text()));
//            alert(Math.round($display.text()));
            var curr_count = parseInt($display.text()) + 1;
            $display.text(curr_count);
        } else {
//        	alert(333);
//        	alert(parseInt($display.text()));
//            alert(Math.round($display.text()));
            clearInterval(int);
        }
    }, int_speed);
}

countUp4(ndzsf);

