import React, { Component } from "react";
import ReactDOM from "react-dom";
import "./index.css";
import { Container } from "reactstrap";
import Student from "./student";
import bootstrap from "bootstrap/dist/css/bootstrap.css";

class App extends Component {
  constructor() {
    super();
    this.state = {
      name: "React"
    };
  }

  render() {
    return (
      <Container>
        <Student />
      </Container>
    );
  }
}

ReactDOM.render(<App />, document.getElementById("root"));
