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
	
	$myFile = "GPSPoints.txt";
	$fh = fopen($myFile, 'a') or die("can't open file");
	
	if (isset($_POST['lat'])) {
    		//file_put_contents("GPSPoints.txt", $_POST['lat']);
		fwrite($fh, "lat: ".$_POST['lat']." ");	
	}

	if (isset($_POST['long'])) {
		fwrite($fh, "long: ".$_POST['long']."\n");
	}

	fclose($fh);

	echo json_encode("I received data.");
	
	?>


<p>Ana are mere.</p>

</body>
</html>