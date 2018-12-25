var ListStyle = {
	backgroundColor:'rgba(0,0,233,0.3)',
	width: 1200,
	height: 800,
	position: 'absolute',
	textAlign: 'left',
	top: 100,
	left: 550,
};
var list = 
	<div style = {ListStyle}>
		<iframe src="book?action=getlist" 
			width="1200" height="800" style = {{border:0}}></iframe>
		<a href="order.jsp"><button style={{fontSize:20,float:'right'}}>结算</button></a>
	</div>
ReactDOM.render(list,document.getElementById("booklist"));