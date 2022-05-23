import React from "react"
import logo from "../images/ivanti-logo.svg";
import facebook from "../images/facebook-logo.svg";
import linkedin from "../images/linkedin-logo.svg";
import twitter from "../images/twitter-logo.svg";
import youtube from "../images/youtube-logo.svg";

function Footer() {
    return (
        <footer className="footer">

            { /*
            <div className="footer-container">
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
            </div>
            */ }
            <img src={logo} height={"38px"} alt={"ivanti logo"}/>
            <img src={linkedin} height={"15px"} alt={"linkedin logo"}/>
            <img src={facebook} height={"15px"} alt={"facebook logo"}/>
            <img src={youtube} height={"15px"} alt={"youtube logo"}/>
            <img src={twitter} height={"15px"} alt={"twitter logo"}/>
            <p className="copyright">Copyright &copy 2022 Ivanti. All rights reserved.</p>
            <p>Webinar</p>
            <p>Events</p>
            <p>Blog</p>
            <p>Careers</p>
            <p>Contact Us</p>
            <p>Privacy & Legal</p>
            <p>Partners</p>
            <p>Press Releases</p>
            <p>Downloads</p>
        </footer>
    )
}

export default Footer