<html>
<head>
    <meta http-equiv="Expires" content="0">
    <meta http-equiv="kiben" content="no-cache">
    <script type="text/javascript" src="js/jquery-1.8.2.js"></script>
</head>
<body>
<h2>Hello World!</h2>

<input id="button" type="button" value="Map 2 json"/>

<script type="text/javascript">
    $("#button").click(function(){
        var url = "${pageContext.request.contextPath}/dep/query";
        var sendData = null;
        $.post(url,sendData,function(backData,textStaut,ajax){
            alert(ajax.responseText);
        });
    });
</script>
</body>
</html>
