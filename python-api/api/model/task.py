import datetime as dt

from marshmallow import Schema, fields


class Task(object):
    def __init__(self, name, complete):
        self.name = name
        self.complete = complete
        self.created_at = dt.datetime.now()

    def __repr__(self):
        return '<Task(name={self.name!r})'.format(self=self)


class TaskSchema(Schema):
    name = fields.Str()
    complete = fields.Bool()
    created_at = fields.Date()



