import React from "react"
import Navbar from "../Header/components/Navbar";

function Footer() {
  return (
    <footer className={"footer"}>
        {/* <div className="footer-container">
            <div className="row">
                <div className="menu">
                    <nav className="row">
                        <div className="menu-col">
                            <div className="menu-item">
                                <a href="https://www.ivanti.com/webinars">webinars</a>
                            </div>
                            <div className="menu-item">
                                <a href="https://www.ivanti.com/company/events">events</a>
                            </div>
                            <div className="menu-item">
                                <a href="https://www.ivanti.com/blog">blog</a>
                            </div>
                        </div>
                        <div className="menu-col">
                        <div className="menu-item">
                                <a href="https://www.ivanti.com/company/careers">careers</a>
                            </div>
                            <div className="menu-item">
                                <a href="https://www.ivanti.com/company/contacts">contact us</a>
                            </div>
                            <div className="menu-item">
                                <a href="https://www.ivanti.com/company/legal">Privacy & legal</a>
                            </div>
                        </div>
                        <div className="menu-col">
                        <div className="menu-item">
                                <a href="https://www.ivanti.com/partners">partners</a>
                            </div>
                            <div className="menu-item">
                                <a href="https://www.ivanti.com/company/press-releases">press releases</a>
                            </div>
                            <div className="menu-item">
                                <a href="https://www.ivanti.com/resources/downloads">downloads</a>
                            </div>
                        </div>
                    </nav>
                </div>
            </div>
        </div> */}
        <div className={"footerLeft"}>
                <img src={"https://drive.google.com/uc?export=view?&id=1kwJ2YBnpj9YgaHTn3_ku1duQSr7b8ZzV\n"} height={"50px"}  alt={"ivanty logo"}/>
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
    </footer>

  )
}

export default Footer