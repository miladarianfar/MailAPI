# MailAPI

A simple program for sending and receiving messages over the web

## Technologies
Project is created with:

* java version : 1.8
* springboot version : 2.5.4
* jpa
* MySQL
* spring rest


## API Reference

#### Get all users

```http
  GET /api/users
```

#### Get all mails

```http
  GET /api/mails
```

#### Get single mail

```http
  GET /api/mail/${id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `int` | **Required**. Id of mail to fetch |

#### Get single user

```http
  GET /api/mail/${username}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `username`      | `String` | **Required**. username of user to fetch |

#### Save user

```http
  POST /api/user/save
```

#### Save mail

```http
  POST /api/mail/save
```  

#### Set receiver

```http
  GET /api/mail/set-recievers/${username}/${mailId}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `username`      | `String` | **Required**. username of user to fetch |
| `mailId`     | `int` | **Required**. id of mail to fetch |

#### Set sender

```http
  GET /api/mail/set-sender/${username}/${mailId}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `username`      | `String` | **Required**. username of user to fetch |
| `mailId`     | `int` | **Required**. id of mail to fetch |

#### Get all sent mail by user

```http
  GET /api/mails/user-sent-mails/{username}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `username`      | `String` | **Required**. username of user to fetch |

#### Get all recieved mail by user

```http
  GET /api/mails/user-recieved-mails/{username}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `username`      | `String` | **Required**. username of user to fetch |
