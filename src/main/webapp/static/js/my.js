var localObj = window.location;

var contextPath = localObj.pathname.split("/");

var basePath = localObj.protocol+"//"+localObj.host+"/"+contextPath[1]+"/"+contextPath[2];
var resPath=localObj.protocol+"//"+localObj.host+"/"+contextPath[1];

