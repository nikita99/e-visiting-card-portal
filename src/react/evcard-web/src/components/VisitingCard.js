import React from 'react';

const VisitingCard = (props) => {

    return(
        <div className="visitingCard">
            <h3>{props.visitingCard.firstName} {props.visitingCard.lastName}</h3>
            <h4>{props.visitingCard.office}</h4>
            <h4>{props.visitingCard.designation}</h4>
            <h4>{props.visitingCard.contact}</h4>
        </div>
    );
}
export default VisitingCard;