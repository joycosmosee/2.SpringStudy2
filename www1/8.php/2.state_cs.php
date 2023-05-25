<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <div class="counter">
        <?php
            include_once('./counter.php');
             echo "오늘 방문자수 : ".$today_visit_count."<br>";
		     echo "전체 방문자수 : ".$total_visit_count."<br>";
        ?>
    </div>
</body>
</html>