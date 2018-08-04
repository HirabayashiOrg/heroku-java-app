(function(){
	'use strict';
	var show = function(data){
		// グラフの種類
		var type = 'line';

		// グラフの設定
		var options = {}

		var ctx = document.getElementById('my_chart').getContext('2d');
		var myChart = new Chart(ctx, {
			type   : type,
			data   : data,
			options: options,
		});
	}

//	var data = {
//		labels: ["01-01","01-02","01-03"],
//		datasets: [{
//			label: 'add',
//			data : [10, 30, 20],
//			borderColor: 'red',
//			backgroundColor: 'rgba(255, 0, 0, 0.3)',
//			lineTension: 0,
//		},{
//			label: 'incremental',
//			data : [8, 15, 13],
//			borderColor: 'blue',
//			backgroundColor: 'rgba(0, 0, 255, 0.3)',
//			lineTension: 0,
//		}]
//	};

	$.get('/github/api/v/github_push',{},function(pushes){
		// データセット用の配列を準備
		var labels = [];
		var addAry = [];
		var incAry = [];
		// データを格納
		for(var i=0; i<pushes.length; i++) {
			labels.push(pushes[i]['pushed']);
			addAry.push(pushes[i]['add']);
			incAry.push(pushes[i]['count']);
		}

		var data = {
			labels: labels,
			datasets: [{
				label: 'add',
				data : addAry,
				borderColor: 'red',
				backgroundColor: 'rgba(255, 0, 0, 0.3)',
				lineTension: 0,
			},{
				label: 'incremental',
				data : incAry,
				borderColor: 'blue',
				backgroundColor: 'rgba(0, 0, 255, 0.3)',
				lineTension: 0,
			}]
		}

		show(data);
	});

})();