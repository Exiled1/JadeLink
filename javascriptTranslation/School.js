var mysql = require('mysql');

var connection = mysql.createConnection({
  host: "172.20.10.9",
  user: "teammate"
  password: "TM:MySQL420"
});

connection.connect(function(err) {
  if (err) throw err;
  console.log("Connected! :D");
})
