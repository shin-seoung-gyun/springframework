$(function() {
	var writer1 = a[0][0];
	var writer2 = a[1][0];
	var writer3 =a[2][0];
	var num1 = a[0][1];
	var num2 = a[0][2];
	var num3 = a[0][3];


    Morris.Donut({
        element: '랭킹 1~3위',
        data: [{
            label: writer1,
            value: 12
        }, {
            label: writer2,
            value: 30
        }, {
            label: writer3,
            value: 20
        }],
        resize: true
    });

});
