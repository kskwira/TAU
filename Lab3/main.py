import requests
import json
import logging

"""API documentation: https://alexwohlbruck.github.io/cat-facts/docs/"""


logging.basicConfig(filename='example.log', filemode='w', level=logging.DEBUG,
                    format='%(asctime)s - %(name)s - %(levelname)s - %(message)s')
logger = logging.getLogger('REST API test')
info_counter = 0
error_counter = 0


# checking response from incorrect link
url = 'https://cat-fact.herokuapp.com/factsss/random'
response = requests.request("GET", url)
try:
    assert response.status_code != 200
    logger.info('Test 1 - correct')
    info_counter += 1
except AssertionError:
    logger.error('Test 1 - response status should not be 200')
    error_counter += 1


# checking the correct response
url = 'https://cat-fact.herokuapp.com/facts/random'
response = requests.request("GET", url)
try:
    assert response.status_code == 200
    logger.info('Test 2 - correct')
    info_counter += 1
except AssertionError:
    logger.error('Test 2 - could not get requested URL')
    error_counter += 1


# checking the expected key values
a = json.loads(response.text)
expected_keys = ['status', '_id', 'user', 'text', '__v', 'source', 'updatedAt', 'type', 'createdAt', 'deleted', 'used']
current_keys = []
for key, value in a.items():
    if key in expected_keys:
        current_keys.append(key)

current_keys.sort()
expected_keys.sort()
try:
    assert expected_keys == current_keys
    logger.info('Test 3 - correct')
    info_counter += 1
except AssertionError:
    logger.error('Test 3 - incorrect or missing keys')
    error_counter += 1


# checking the animal_type parameter
query = {'animal_type': 'dog'}
response = requests.get(url, query)
a = json.loads(response.text)
for key, value in a.items():
    if key == 'type':
        query_type = value

try:
    assert query.get('animal_type') == query_type
    logger.info('Test 4 - correct')
    info_counter += 1
except AssertionError:
    logger.error(f'Test 4 - incorrect animal type, should be "{query.get("animal_type")}" but got "{query_type}" instead')
    error_counter += 1


# checking the amount parameter
query = {'amount': '15'}
response = requests.get(url, query)
a = json.loads(response.text)
try:
    assert len(a) == 15
    logger.info('Test 5 - correct')
    info_counter += 1
except AssertionError:
    logger.error(f'Test 5 - incorrect number of facts, should be {query.get("amount")} but got {len(a)} instead')
    error_counter += 1


# checking the GET fact by specific ID (comparing fact text)
url = 'https://cat-fact.herokuapp.com/facts/'
fact_id = '591f98803b90f7150a19c229'
fact_text = 'In an average year, cat owners in the United States spend over $2 billion on cat food.'
response = requests.request("GET", url + fact_id)
a = json.loads(response.text)
for key, value in a.items():
    if key == 'text':
        query_text = value
    if key == '_id':
        query_id = value

try:
    assert fact_text == query_text
    logger.info('Test 6 - correct')
    info_counter += 1
except AssertionError:
    logger.error(f'Test 6 - got incorrect fact\n'
                 f'Fact id: {query_id}\n'
                 f'Fact text: {query_text}\n')
    error_counter += 1


# checking if user not logged in/signed in
url = 'https://cat-fact.herokuapp.com/users/me'
message = 'Sign in first'
response = requests.request("GET", url)
a = json.loads(response.text)
try:
    assert a.get('message') == message
    logger.info('Test 7 - correct')
    info_counter += 1
except AssertionError:
    logger.error('Test 7 - user already logged in')
    error_counter += 1


# checking if you can post data
data = {
    'text': "Test post.",
    'type': "cat"
}
response = requests.post('https://cat-fact.herokuapp.com/facts', data=data)
a = json.loads(response.text)
try:
    assert response.status_code == 204
    logger.info('Test 8 - correct')
    info_counter += 1
except AssertionError:
    logger.error(f'Test 8 - post unsuccessful, response message: {a.get("message")}')
    error_counter += 1


logger.info(f'Tests completed\n'
            f'Number PASSED: {info_counter}\n'
            f'Number FAILED: {error_counter}')

