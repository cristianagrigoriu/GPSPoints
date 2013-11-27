<!DOCTYPE html>
<html>
<head>
<link type="text/css""/>
<meta charset=utf-8 />
<title>Table JavaScript</title>
</head>
<body>
	<button onclick="alert('Aici se intimpla ceva!')">Aici</button>
 	<?php 
	echo "<p>1</p>";
	//echo "<p>$_POST['lat']</p>";
	//echo "<p>$_POST['long']</p>";

	echo "lat";	
	
	$myFile = "GPSPoints.txt";
	$fh = fopen($myFile, 'a') or die("can't open file");
	
	if (isset($_POST['lat'])) {
		echo "lat";
    		//file_put_contents("GPSPoints.txt", $_POST['lat']);
		fwrite($fh, "lat: ".$_POST['lat']." ");	
	}

	echo " long";

	if (isset($_POST['long'])) {
		echo "long";
		fwrite($fh, "long: ".$_POST['long']."\n");
	}

	fclose($fh);

	?>


<p>Ana are mere.</p>

</body>
</html>