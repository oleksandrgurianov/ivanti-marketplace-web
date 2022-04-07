/*Parent class
-Receives state data from Input
-Contains state data
-Shares state data with Nav, Header, List and Input*/
import React from "react"
import List from "./List"; //gets data from List component


class Container extends React.Component {
state = {
 menu: [
   {
     id: 1,
     title: "App 1",
     version: 2.1
   },
   {
     id: 2,
     title: "App 2",
     version: 1.2
   },
   {
     id: 3,
     title: "Appe 3",
     version: 2.3
   }
 ]
};

  render() {
    return (
      <div>
      <h2> Hello I am the page container! </h2>
      {/*LIST EXAMPLE/ <List menu={this.state.menu} />*/}
      </div>
    );
  }
}
export default Container
