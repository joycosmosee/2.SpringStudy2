<?php
	include_once("1.data_con.php");

	if($_REQUEST['consult_company_name']){
		$consult_company_name	= $_REQUEST['consult_company_name'];
		$consult_name			= $_REQUEST['consult_name'];
		$consult_hp				= $_REQUEST['consult_hp'];
		$consult_email			= $_REQUEST['consult_email'];
		$consult_content		= $_REQUEST['consult_content'];
		
		/*
		$consult_company_name	= "회사명";
		$consult_name			= "성명";
		$consult_hp				= "010-5333-7027";
		$consult_email			= "ryudh@jwindwish.com";
		$consult_content		= "윈드위시에게 문의드립니다";
		*/

		$sql = " insert into wp_consult_list (consult_company_name,consult_name,consult_hp,consult_email,consult_content,consult_regdate,consult_IP) VALUES ('{$consult_company_name}','{$consult_name}','{$consult_hp}','{$consult_email}','{$consult_content}',now(),'{$_SERVER['REMOTE_ADDR']}') ";
		$result = mysqli_query($conn, $sql);
    
?>
<script>
	alert("컨설팅 서비스 신청이 완료되었습니다.");
	location.href="/windwish2/";
</script>
<?php
	} else {
?>
<script>
	alert("정확한 정보를 입력하여 주세요.");
	history.back();
</script>
<?php
	}
?>