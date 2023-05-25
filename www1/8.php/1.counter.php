<?php

	$db = mysqli_connect('localhost','windwish','skywind36','windwish') or die('Can not Access DB');
	
		$now_time = date("Y-m-d H:i:s");
		$currdt = date("Y-m-d H:i:s", strtotime("-10 minutes", strtotime($now_time)));
		$userip = $_SERVER['REMOTE_ADDR'];

		if(isset($_SERVER['HTTP_REFERER'])) {
			$referer = $_SERVER['HTTP_REFERER'];  
		} else {
			$referer = ""; 
		}

		// 10분이내 동일 IP에 새로고침은 카운트 안함
		$query = "select count(*) as count from tb_stat_visit where regdate between '{$currdt}' and now() and regip = '{$userip}' ";
		$data = $db->query($query)->fetch_array();
		$today_visit_count = $data['count'];

			
		if($today_visit_count == '0') { 
			$query = "insert into tb_stat_visit (regdate, regip, referer) values('$now_time','$userip','$referer')";
			$result = $db->query($query);
		}
			
		// 오늘 방문자수
		$query = "select count(*) as count from tb_stat_visit where DATE(regdate) = DATE('$currdt')";
		$data = $db->query($query)->fetch_array();
		$today_visit_count = $data['count'];
		
		// 전체 방문자수
		$query = "select count(*) as count from tb_stat_visit";
		$data = $db->query($query)->fetch_array();
		$total_visit_count = $data['count'];
			
		// echo "오늘 방문자수 : ".$today_visit_count."<br>";
		// echo "전체 방문자수 : ".$total_visit_count."<br>";
		
?>