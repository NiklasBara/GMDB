import React, { Component } from 'react';
import { Collapse, Nav, Navbar, NavbarBrand, NavbarToggler, NavItem, NavLink } from 'reactstrap';
import { Link } from 'react-router-dom';

export default class AppNavbar extends Component {
    constructor(props) {
        super(props);
        this.state = { isOpen: false };
        this.toggle = this.toggle.bind(this);
    }
    toggle() {
        this.setState({
            isOpen: !this.state.isOpen
        });
    }
    render() {
        return <Navbar color="dark" dark expand="md" sticky='top'>
            <NavbarBrand tag={Link} to="/">Home</NavbarBrand>
            <NavbarToggler onClick={this.toggle} />
            <Collapse isOpen={this.state.isOpen} navbar>
                <Nav className="ml-auto" navbar>
                    <NavItem>
                        <NavLink tag={Link} to="/">Home</NavLink>
                    </NavItem>
                    <NavItem>
                        <NavLink tag={Link} to="/movie">Movies</NavLink>
                    </NavItem>
                    <NavItem>
                        <NavLink tag={Link} to="/">Link 3</NavLink>
                    </NavItem>
                    <NavItem>
                        <NavLink tag={Link} to="/">Link 4</NavLink>
                    </NavItem>
                    <NavItem>
                        <NavLink tag={Link} to="/">Link 5</NavLink>
                    </NavItem>
                </Nav>
            </Collapse>
        </Navbar>;
    }
}