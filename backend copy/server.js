const express = require('express');
const mysql = require('mysql');
const cors = require('cors');

const app = express();
const port = 3000;

app.use(express.json());
app.use(cors()); // Enable CORS for all routes



// app.get('/api/data', (req, res) => {
//   res.json({ message: 'This is your data from the back-end!' });
// });


app.listen(port, () => {
  console.log(`Server is running on port ${port}`);
});
