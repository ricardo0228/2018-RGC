
var userName = document.getElementById("Login").getAttribute("userName");
var astyle = {
    textDecoration: 'none',
    color: 'red'
};
var background_style = {
    position:'absolute',
    right:0,
    top:0,
    margin: 0,
    width: 400,
    height: 'auto'
};
var content_style = {
    position:'absolute',
    right:0,
    top:10,
    margin: 0,
    width: 400,
    height: 'auto',
    fontSize:20,
    textAlign:'center'
};
var Tourist = <p  style={content_style}>您目前的身份是<b> 游客 </b>  请先<a href="login.jsp" style={astyle}> 登录 </a>|<a href="register.jsp" style={astyle}> 注册 </a></p>;
var User = <p  style={content_style}>欢迎回来，<b>{userName}</b>！您可以<a href="information.jsp" style={astyle}>修改资料</a>|<a style={astyle} href="logout.jsp">注销</a></p>;
var Admin = <p  style={content_style}>欢迎回来，<b>{userName}</b>！您可以<a href="manager.jsp" style={astyle}>后台管理</a>|<a style={astyle} href="logout.jsp">注销</a></p>;
var sign;
sign = <div>
	<img src = "files/PIC/login.png"  style={background_style}/>
	{userName == "null" ? Tourist : userName == "admin" ? Admin : User}
</div>
ReactDOM.render(sign,document.getElementById("Login"));