import React from "react"
import Navbar from "./Navbar";

function Footer() {
  return (
    <div className={"footer"}>
        <div className={"footerLeft"}>
            <img src={"https://drive.google.com/uc?export=view?&id=1kwJ2YBnpj9YgaHTn3_ku1duQSr7b8ZzV\n"} height={"70px"}  alt={"ivanty logo"}/>
        </div>
        <div className={"footerRight"}>
            <div className={"block"}>
                <div className={"inline-block"}>
                    <p className={"block"}>Webinar</p>
                    <p className={"block"}>Events</p>
                    <p className={"block"}>Blog</p>
                </div>
                <div className={"inline-block"}>
                    <p className={"block"}>Careers</p>
                    <p className={"block"}>Contact Us</p>
                    <p className={"block"}>Privacy & Legal Us</p>
                </div>
                <div className={"inline-block"}>
                    <p className={"block"}>Partners</p>
                    <p className={"block"}>Press Releases</p>
                    <p className={"block"}>Downloads</p>
                </div>
            </div>
        </div>
    </div>

  )
}

export default Footer