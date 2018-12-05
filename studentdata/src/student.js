import React from "react";
import {
  Button,
  Row,
  Col,
  Label,
  FormGroup,
  Input,
  Container
} from "reactstrap";
import axios from "axios";

export default class student extends React.Component {
  constructor(props) {
    super(props);

    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
    this.state = { data: { courses: [] } };
  }

  handleChange = e => {
    let { data } = this.state;
    data[e.target.name] = e.target.value;
    this.setState({ data });
    console.log("----------", this.state);
  };

  handleCourses = e => {
    let { data } = this.state;
    let { courses } = data;
    courses.push(e.target.value);
    this.setState({ data });
    console.log(data);
  };

  handleSubmit(event, errors, values) {
    let { data } = this.state;
    console.log(data);

    console.log("hi", data);
    axios({
      method: "post",
      headers: {
        "Access-Control-Allow-Origin": "*",
        "Access-Control-Allow-Methods": "GET,PUT,POST,DELETE,PATCH,OPTIONS"
      },
      url: "http://localhost:3000/student/create",
      data
    }).then(response => {
      console.log(response);
    });
    this.setState({ errors, values });
  }

  render() {
    return (
      <React.Fragment>
        <Container>
          <FormGroup
            controlId="formValidationSuccess1"
            validationState="success"
          >
            <Row>
              <Col>
                <Label for="name">Name</Label>
                <Input
                  name="name"
                  value={this.state.name}
                  required
                  onChange={e => this.handleChange(e)}
                />
              </Col>
            </Row>
          </FormGroup>
          <FormGroup controlId="formValidationError1" validationState="error">
            <Row>
              <Col>
                <Label for="uniqueid">Unique Id</Label>
                <Input
                  name="uniqueId"
                  value={this.state.uniqueId}
                  required
                  onChange={e => this.handleChange(e)}
                />
              </Col>
            </Row>
          </FormGroup>
          <FormGroup>
            <Row>
              <Col>
                <Label for="description">Description</Label>
                <Input
                  name="description"
                  value={this.state.description}
                  required
                  onChange={e => this.handleChange(e)}
                />
              </Col>
            </Row>
          </FormGroup>
          <FormGroup>
            <Row>
              <Col>
                <Label for="courses">Courses</Label>
                <Input
                  type="select"
                  name="courses"
                  value={this.state.courses}
                  multiple
                  onChange={e => this.handleCourses(e)}
                >
                  <option>Maths</option>
                  <option>Science</option>
                  <option>History</option>
                  <option>English</option>
                  <option>Graphics</option>
                </Input>
              </Col>
            </Row>
          </FormGroup>
          <Button onClick={this.handleSubmit}>Submit</Button>

          <Row>
            {this.state.values && (
              <div>
                <h3>FORM DATA</h3>
                Details: {this.state.errors.join(", ")}
                <br />
                Provided:{" "}
                <pre>{JSON.stringify(this.state.values, null, 2)}</pre>
              </div>
            )}
          </Row>
        </Container>
      </React.Fragment>
    );
  }
}
