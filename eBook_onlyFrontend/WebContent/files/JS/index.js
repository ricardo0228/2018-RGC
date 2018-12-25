var astyle = {
    textDecoration: 'none',
    color: 'deepskyblue'
};
var istyle = {
    position:'relative',
    width: 440,
    height: 120,
    margin:60,
    top:60
};
var pstyle = {
    fontFamily: 'STKaiti',
    fontSize: 24,
    color: '#ffffcc',
    textAlign: 'right'
};
var tstyle = {
    backgroundColor: 'rgba(0,0,0,0.3)',
    textAlign: 'center',
    margin: 'auto',
    width: 300,
    height: 400,
    fontFamily:'SimHei',
    fontSize: 46,
    textDecoration: 'none',
    color: 'deepskyblue'
};
var d3 = <div style={tstyle}>
    <hr />
    <a href="list1.jsp" style={astyle}>冉冉新星</a>
    <hr />
    <a href="list2.jsp" style={astyle}>熠熠生辉</a>
    <hr />
    <a href="list3.jsp" style={astyle}>星罗棋布</a>
    <hr />
    <a href="list4.jsp" style={astyle}>随遇而安</a>
    <hr />
</div>
ReactDOM.render(
    <img src = "files/PIC/title.png" style={istyle}/>,
    document.getElementById("D1")
);
ReactDOM.render(
    <p style={pstyle}>书如星海，茫茫无数</p>,
    document.getElementById("D2")
);
ReactDOM.render(d3,document.getElementById("D3"));
