import React from "react"

class Item extends React.Component {

  render() {
    return <li>{this.props.myitem.title}</li>
  }
}

export default Item