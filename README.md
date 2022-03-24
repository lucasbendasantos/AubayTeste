
# Survey App Test Aubay

This test was done with the purpose of evaluating logic and data structure, it consists of an API construction for a survey tool


## Download Area
please download the files and import in your postman.

[Postman files](https://github.com/lucasbendasantos/AubayTeste/tree/master/postman)
## API Server
This API is running on Heroku using MongoDB Atlas as a database

| Server | URL     |
| :-------- | :------- | 
| Heroku | `https://aubay-survey.herokuapp.com/` | 
| MongoDB Atlas | `https://cloud.mongodb.com/` | 


## How use?

**Step 1:** Create a Coordinator, after you have imported the files, go to the AUBAY collection -> Coordinator -> Create
this endpoint is responsible for creating a coordinator, you can change the information in the request body

**cURL Example**

```bash
curl --location --request POST 'https://aubay-survey.herokuapp.com/coordinator' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name":"Lucas 2",
    "document":"010203",
    "email":"lucas@lucas"
}'
```



**Step 2:** After creating the Coordinator, you can create a survey, every survey is tied to a Coordinator's document.

Here we can define:

**Structure of the Survey**
| Field  | Type   |
| ------------ | ------------ |
|  title | survey's title  |
|  status |  A=Active/ C=closed |
|  coordinator | previously registered document   |
|  Question | list of up to 10 questions   |

**Structure of the question**
| Field  | Type   |
| ------------ | ------------ |
|  numberQuestion | question number  |
|  description |  question description |
|  multipleChoice | if the question allows for more than one correct answer(true/false)   |
|  answers | list of the 5 alternatives of the question   |

**Structure of the answer**
| Field  | Type   |
| ------------ | ------------ |
|  option | to identify the alternative  |
|  description |  answer description |
|  checked | whether the alternative is correct or not   |

Below we can see an example of two questions for a survey

**cURL Example**
```
curl --location --request POST 'https://aubay-survey.herokuapp.com/survey' \
--header 'Content-Type: application/json' \
--data-raw '{
    "title":"My First Survey",
    "status":"A",
    "coordinator":{
        "document": "010203"
    },
    "questions":[
        {
            "numberQuestion": 1,
            "description": "how many people live in lisbon?",
            "multipleChoice": false,
            "answers" : [
                {"option": "A", "description": "504.718", "checked": true},
                {"option": "B", "description": "400.000", "checked": false},
                {"option": "C", "description": "100.000", "checked": false},
                {"option": "D", "description": "50.000", "checked": false},
                {"option": "E", "description": "10.000", "checked": false}
            ]

        },


         {
            "numberQuestion": 2,
            "description": "Primitives types in java",
            "multipleChoice": true,
            "answers" : [
                {"option": "A", "description": "int", "checked": true},
                {"option": "B", "description": "double", "checked": true},
                {"option": "C", "description": "String", "checked": false},
                {"option": "D", "description": "Boolean", "checked": false},
                {"option": "E", "description": "Integer", "checked": false}
            ]

        }
    ]
}'
```

**Step 3:** Create a answer,In this step, we must register a respondent, where in the future we will be able to start responding to a survey with him.

**cURL Example**

```bash
curl --location --request POST 'https://aubay-survey.herokuapp.com/respondent' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "Lucas Respondent",
    "document": "123456789",
    "email": "lucas@lucas"
}'
```

**Step 4:** respondent linking to a survey, below, we will see how we link a survey to a respondent Here, we can send a completed survey, and the respondent's document

**IMPORTANT** 

- at this moment, the response structure represents the answer that the respondent gave to a given question, so the answer that is checked with true
- the ID sent is the ID of a previously registered survey
```bash
curl --location --request POST 'https://aubay-survey.herokuapp.com/respondent/answerSurvey?documentRespondent=123456789' \
--header 'Content-Type: application/json' \
--data-raw '{
        "id": "623b5a31b63e07650193edbe",
        "title": "My First Survey",
        "status": "A",
        "coordinator": {
            "id": "623a82d4bb2e6e3d533f3bd8",
            "name": "Lucas",
            "document": "123456789",
            "email": "lucas@lucas"
        },
        "questions": [
            {
                "numberQuestion": 1,
                "description": "how many people live in lisbon?",
                "multipleChoice": false,
                "answers": [
                    {
                        "option": "E",
                        "description": "10.000",
                        "checked": false
                    },
                    {
                        "option": "D",
                        "description": "50.000",
                        "checked": false
                    },
                    {
                        "option": "B",
                        "description": "400.000",
                        "checked": false
                    },
                    {
                        "option": "A",
                        "description": "504.718",
                        "checked": true
                    },
                    {
                        "option": "C",
                        "description": "100.000",
                        "checked": false
                    }
                ]
            },
            {
                "numberQuestion": 2,
                "description": "Primitives types in java",
                "multipleChoice": true,
                "answers": [
                    {
                        "option": "C",
                        "description": "String",
                        "checked": true
                    },
                    {
                        "option": "A",
                        "description": "int",
                        "checked": false
                    },
                    {
                        "option": "E",
                        "description": "Integer",
                        "checked": false
                    },
                    {
                        "option": "B",
                        "description": "double",
                        "checked": true
                    },
                    {
                        "option": "D",
                        "description": "Boolean",
                        "checked": false
                    }
                ]
            }
        ]
    }'
```

### Other Features

- We can **CLOSE** the survey:
```shell
curl --location --request POST 'https://aubay-survey.herokuapp.com/survey/close?documentCoordinator=123456789&idSurvey=623b615d7f030a40027236e4'
```

- We can **ACTIVE** the survey:
```shell
curl --location --request POST 'https://aubay-survey.herokuapp.com/survey/active?documentCoordinator=123456789&idSurvey=623b615d7f030a40027236e4'
```
