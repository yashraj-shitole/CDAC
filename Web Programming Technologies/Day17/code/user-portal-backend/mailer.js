const nodemailer = require('nodemailer')
const config = require('./config')

function sendEmail(email, subject, body, callback) {
  // create a transporter
  const transporter = nodemailer.createTransport({
    service: 'gmail',
    host: 'smtp.gmail.com',
    auth: {
      user: config.email,
      pass: config.password,
    },
  })

  // create email options
  const mailOptions = {
    from: config.email,
    to: email,
    subject: subject,
    html: body,
  }

  // send the email
  transporter.sendMail(mailOptions, (error, result) => {
    console.log(error)
    console.log(result)
    callback(error, result)
  })
}

module.exports = {
  sendEmail,
}
