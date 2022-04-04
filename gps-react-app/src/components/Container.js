/*Parent class
-Receives state data from Input
-Contains state data
-Shares state data with Nav, Header, List and Input*/
import React from "react"
import List from "./List"; //gets data from List component
import Header from "./Header";


class Container extends React.Component {
state = {
 menu: [
   {
     id: 1,
     title: "Element 1",
   },
   {
     id: 2,
     title: "Element 2",
   },
   {
     id: 3,
     title: "Element 3",
   }
 ]
};
  /*The data is defined as state in the Container component (also posible from db), then i pass it as prop. trough the render. The List component will take it  */
  render() {
    return (
      <div>
      <h2> Hello, I am the Container and i am showing a menu:)
       I should show the page when you click a link on the Navbar</h2>
      <List menu={this.state.menu} />
      </div>
    );
  }
}
export default Container
