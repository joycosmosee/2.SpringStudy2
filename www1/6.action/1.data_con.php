<?php
	
	$host = 'localhost';
    $user = 'windwish';
    $pw = 'skywind36';
    $dbName = 'windwish';
    $conn = new mysqli($host, $user, $pw, $dbName);
 
    if(!$conn){
        echo "MySQL 접속 실패"."<br>";
    }

	/* SELECT 예제 */
	/*
	$sql = "SELECT * FROM wp_comments";
    $result = mysqli_query($conn, $sql);
    while($row = mysqli_fetch_array($result)){
        echo $row['comment_author']." ".$row['comment_author_email']."<br>";
    }
    
	*/
?>
