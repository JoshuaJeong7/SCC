function changeButton(){
    console.log("test console message")
    currentText = document.getElementById('customButton').innerHTML;
    if(currentText == "Change back"){
        document.getElementById('customButton').innerHTML = "Change to something else"
    }
    else{
        document.getElementById('customButton').innerHTML = "Change back";
    }

}
//Javascript Comment