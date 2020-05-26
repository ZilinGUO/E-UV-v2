function  gotoReponsePage(eid){
debugger;
    window.parent.document.getElementById("J_iframe").setAttribute('src',"/Response/setResponse.do?eid="+eid);

}