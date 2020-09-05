import React, { Component } from 'react';
import {Modal} from 'react-bootstrap';
import {Button} from 'react-bootstrap';
import NewPage from './newpage';

class AppDragDropDemo extends Component {
  state = 
  {
    show :false,
    title:"A",
    desc :"B ",
    cdate:"C",
    color :"",
    tasks :
    [
      {category : "new",descreption : "Home Tour",creationDate :"25/08/2020",taskname :"Task1", state : "new",bgcolor:"tan"},
      {taskname :"Task4",descreption : "time management",creationDate : "21/05/2020",category : "inprogress",state : "inprogress",bgcolor:"skyblue"},
      {taskname :"Task6",descreption : "office work",creationDate : "08/05/2020",category : "completed",state : "completed",bgcolor:"red"}
    ]
   }
  onDragStart = (ev,id) =>
  {
    console.log('dragstart:',id);
    ev.dataTransfer.setData("id",id);
  }
 onDragOver = (ev) =>
 {
    ev.preventDefault();
 }
onDrop = (e,cat) => 
{
    let id = e.dataTransfer.getData("id");
    let tasks = this.state.tasks.filter((task) =>
    {
        if(task.taskname === id)
        {
            task.category = cat;
            task.state = cat;
        }
        if(task.category === "inprogress")
        {
            task.bgcolor = "skyblue";
        }
        if(task.category === "completed")
        {
            task.bgcolor = "red";
        }
        return task;
    })
    this.setState({
        ...this.state,tasks
    });
}
   handleClose =() =>
  {
    this.setState({show : false})
  }
  handleShow =() =>
  {
    this.setState({show:true})
  }
  getData1 = (taskTitle,description,creationDate,priority) => {
    console.log(priority)
    if(priority === "High")
    {
        this.state.color = "red"
    }
    if(priority === "Medium")
    {
      this.state.color = "green"
    }
    if(priority === "Low")
    {
      this.state.color = "yellow"
    }
    this.state.title = taskTitle
    this.state.desc = description
    this.state.cdate = creationDate
    this.state.prty = priority
    console.log(this.state)
    }
  render() 
  {
    var tasks = 
    {
      new :[],
      inprogress :[],
      completed :[]
    }
  this.state.tasks.forEach((t) =>
  {
      tasks[t.category].push(
          <div key = {t.category}
              className = "task"
              onDragStart = {(e)=>this.onDragStart(e,t.taskname)}
              draggable
              style = {{backgroundColor:t.bgcolor}}>
              <h6> Task Title :{t.taskname}</h6>
              <h6>Task description: {t.descreption}</h6>
              <h6>Creation Date: {t.creationDate}</h6>
              <h6>Status : {t.state}</h6>
          </div>
      );
  }); 
    return ( 
            <div>
              <div>
                <h2>My Task Tracker</h2>
              </div>
                <hr className ="line"></hr>
                <Button variant="primary"  
                className = "btnn" 
                onClick={this.handleShow}>
                New Task
                </Button>
                <Modal 
                show={this.state.show} 
                onHide={this.handleClose }>
                <Modal.Header closeButton>
                <Modal.Title>Modal heading</Modal.Title>
                </Modal.Header>
                <Modal.Body><NewPage 
                onChange = {this.getData1}/></Modal.Body>
                <Modal.Footer>
                <Button variant="secondary" 
                onClick={this.handleClose }>
                Close
                </Button>
                <Button variant="primary" 
                onClick={this.handleClose }>
                Save Changes
                </Button>
                </Modal.Footer>
                </Modal>
          <div>
            <div>
                <div className = "container1">
                    <h1>New</h1>
                    {tasks.new}
                </div>
                <div className = "container1"  
                onDrop = {(e)=>this.onDrop(e,"inprogress")} 
                onDragOver = {(e) => this.onDragOver(e)}>
                <h1>InProgress</h1>
                {tasks.inprogress}
                </div>
                <div className = "container1" 
                onDrop = {(e)=>this.onDrop(e,"completed")} 
                onDragOver = {(e) => this.onDragOver(e)}>
                <h1>Completed</h1>
                {tasks.completed}
                </div>
            </div>
          </div>
        </div>
     );
  }
}
 
export default AppDragDropDemo;