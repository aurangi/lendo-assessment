# Spring Boot JWT Authentication API Assessment

This is a Spring Boot application demonstrating JWT authentication and basic CRUD operations for managing users, posts, and comments. Users can authenticate using a JWT token and then access different resources like posts, comments, and users.

## Table of Contents

- [Overview](#overview)
- [Authentication](#authentication)
- [Endpoints](#endpoints)
  - [Authentication Endpoint](#authentication-endpoint)
  - [Posts Endpoints](#posts-endpoints)
  - [Comments Endpoints](#comments-endpoints)
  - [Users Endpoints](#users-endpoints)
- [Setup](#setup)
- [Technologies](#technologies)
- [License](#license)

## Overview

This API allows users to authenticate using a username and password, after which they receive a JWT token that can be used for accessing other endpoints like posts, comments, and users.

### Default Users
- **Username**: `lendo`, **Password**: `123456`
- **Username**: `aurang`, **Password**: `123456`

## Authentication

### Authentication Endpoint

**POST** `/auth/api/user`

This endpoint is used to authenticate a user and retrieve a JWT token.

#### Request Body:

```json
{
  "username": "lendo",
  "password": "123456"
}

