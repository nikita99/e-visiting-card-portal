import React, {useState} from "react";
import { useHistory } from "react-router-dom";


const CreateVcard = (props) => {
    const history = useHistory();
    const isloggedin = props.isloggedin;
    
    if(isloggedin !== "true"){
        history.push("/login");
        return null;
    }
    const [createVcardState, setCreateVcardState] = useState({
        firstName: "",
        lastName: "",
        office: "",
        designation:"",
        contact:""
    });
    
    const handleChange = (event) => {
        const target = event.target;
        const value = target.value;
        const name = target.name;
        setCreateVcardState({ ...createVcardState, [name]: value });
    }

    const handleSubmit = (event) =>{
        event.preventDefault();
        const createVcardRequest = {
            firstName: createVcardState.firstName,
            lastName: createVcardState.lastName,
            office: createVcardState.office,
            designation: createVcardState.designation,
            contact: createVcardState.contact
        }
    }

    return (
        <div>
      <form onSubmit={handleSubmit}>
        <label>
          First Name:
          <input
            type="text"
            name="firstName"
            value={createVcardState.firstName}
            onChange={handleChange}
          />
        </label>
        <br />
        <label>
          Last Name:
          <input
            type="text"
            name="lastName"
            value={createVcardState.lastName}
            onChange={handleChange}
          />
        </label>
        <br />
        <label>
          Office:
          <input
            type="text"
            name="office"
            value={createVcardState.office}
            onChange={handleChange}
          />
        </label>
        <br />
        <label>
          Designation:
          <input
            type="text"
            name="designation"
            value={createVcardState.designation}
            onChange={handleChange}
          />
        </label>
        <br />
        <label>
          Contact:
          <input
            type="text"
            name="contact"
            value={createVcardState.contact}
            onChange={handleChange}
          />
        </label>
        <br />
        <br />
        <input type="submit" value="Submit" />
      </form>
    </div>
    );
}

export default CreateVcard;