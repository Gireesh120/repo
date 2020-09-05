import React, { Component } from 'react';
import './newpage.css';
import {Modal} from 'react-bootstrap';
import {Button} from 'react-bootstrap';
import AppDragDropDemo from './AppDragDropDemo';

const initialState = 
{
    tasktitle :"",
    description:"",
    state:"new",
    priority :"",
    creationdate :"",
    tasktitleError : "",
    descriptionError : "",
    priorityError : "",
    creationdateError : "",
    next :false,
    show :false
}
class NewPage extends Component 
{
  state = initialState;
  constructor (props) 
  {
    super(props)
    this.inputRef = React.createRef()
    this.validate = this.validate.bind(this);
  }
  focusInput (){
    this.inputRef.current.focus()
  }
  handletaskname = (event) =>
  {
    this.setState({ tasktitle: event.target.value});
    console.log(this.state.tasktitle)
  }
  handletaskdescription = (event) =>
  {
    this.setState({description: event.target.value});
    console.log(this.state.description)
  }
  handlecreationdate = (event) =>
  {
    this.setState({creationdate : event.target.value});
    console.log(this.state.creationdate)
  }
  handlepriority= (event) =>{
    if(event.target.value === "Male")
    {
      this.setState({priority:"High"});
    }
    if(event.target.value === "Female")
    {
      this.setState({priority:"Medium"});
    }
    if(event.target.value === "Other")
    {
      this.setState({priority:"Low"});
    }
    console.log(this.state.priority)
    
  }
  validate = event => 
    {
        let tasktitleError = "";
        let descriptionError = "";
        let priorityError = "";
        let creationdateError = "";
        if(!this.state.tasktitle)
        {
          tasktitleError ="Please fill the field"
        }
        if(!this.state.description)
        {
          descriptionError="description should not be empty "
        }
        if(!this.state.creationdate)
        {
            creationdateError="Date Error"
        }
        if(!this.state.priority)
        {
          priorityError="please give the appropriate priority"
        }
        if (tasktitleError  || descriptionError ||  priorityError || creationdateError ) 
        {
            this.setState({
                tasktitleError,
                descriptionError,
                priorityError ,
                creationdateError 
            });
            return false;
        }
        return true;
    }
    
    OnNextevent1  = ()=> 
    {
        return(
             this.setState({next1 : true})
        );
    }
    handleClose =() =>
    {
      this.setState({show : false})
    }
    handleSubmit = (event) =>
    {
      event.preventDefault();
      const isValid = this.validate();
      if (isValid)
      {
        this.setState({show:true})
        this.inputRef.current.focus()
        this.props.onChange(this.state.tasktitle,this.state.description,this.state.creationdate,this.state.priority)
      }
  }
    render() { 
        return (
            <div>
                <div className="split left">
                    <div className="centered">
                        <img src="logo1.png" alt="Avatar woman"/>
                        <h2>SwapWindow Task Management System</h2>
                        <p>Makes Your Task Management Easier</p>
                    </div>
                </div>
            <div className="split right">
                <div className="centered">
                <div className="container">  
                    <center>  <h1>Task Details</h1> </center>  
                    <hr></hr> 
                    <label>
                    Title: 
                    </label> 
                    <input type ="text" ref = {this.inputRef} placeholder = "Enter Title Name"
                    value = {this.state.tasktitle}
                    onChange = {(event) => this.handletaskname(event)} />
                    <div style ={{fontSize : 12,color : "red"}}>
                    {this.state.tasktitleError}</div>
                    <label>
                    Description :
                    </label>
                    <textarea cols="80"  
                    type = "text" 
                    rows="5" 
                    placeholder = "Task Description" 
                    onChange = 
                    {(event) => this.handletaskdescription(event)}
                    ref = {this.inputRef} 
                    value ={this.state.description}></textarea> 
                    <div style ={{fontSize : 12,color : "red"}}>
                    {this.state.descriptionError}</div>
                    <label>
                    Creation date : 
                    </label>
                    <input type = "date"
                    ref = {this.inputRef}
                    onChange = {(event) => this.handlecreationdate(event)} 
                    value ={this.state.creationdate}/><p></p> 
                    <div style ={{fontSize : 12,color : "red"}}>
                    {this.state.creationdateError}</div><br></br>
                    <label>
                    Completion date : 
                    </label> 
                    <input type = "date" 
                    ref = {this.inputRef}
                    placeholder = "02/02/2009"/><br></br>
                    <label><b>
                    Priority:
                    </b></label>
                    <div  onChange = {(event) =>this.handlepriority(event)}>
                    <input 
                    type="radio" 
                    value="Male" 
                    name="gender" 
                    ref = {this.inputRef}
                    required />HIGH
                    <input 
                    type="radio" 
                    ref = {this.inputRef}
                    value="Female" 
                    name="gender" /> MEDIUM
                    <input 
                    type="radio" 
                    ref = {this.inputRef}
                    value="Other" 
                    name="gender" /> LOW
                    </div>
                    <div style ={{fontSize : 12,color : "red"}}>
                    {this.state.priorityError}</div>
                    <Button variant="primary"  
                    className = "registerbtn" 
                    onClick={this.handleSubmit}>
                    Create Task</Button> 
                    <Modal show={this.state.show} 
                    onHide={this.handleClose }>
                    <Modal.Header closeButton>
                    <Modal.Title>Modal heading</Modal.Title>
                    </Modal.Header>
                    <Modal.Body><AppDragDropDemo/></Modal.Body>
                    <Modal.Footer>
                    <Button  
                    variant="secondary" 
                    onClick={this.handleClose }>
                    Close
                    </Button>
                    <Button  
                    variant="primary" 
                    onClick={this.handleClose }>
                    Save Changes
                    </Button>
                    </Modal.Footer>
                    </Modal>  
                </div>
            </div>
          </div>
      </div>
         );
    }
} 
export default NewPage;