from flask import Flask, jsonify, request

from api.model.task import Task, TaskSchema

app = Flask(__name__)

tasks=[
	Task('go grocery shooping', 'false'),
	Task('walk the dog', 'false')
]


@app.route("/tasks")
def get_tasks():
	schema = TaskSchema(many=True)

	taskResult = schema.dump(tasks)

	return jsonify(taskResult)


@app.route('/task', methods=['POST'])
def add_task():
	schema = TaskSchema().load(request.get_json())

	tasks.append(schema)

	return '', 204

