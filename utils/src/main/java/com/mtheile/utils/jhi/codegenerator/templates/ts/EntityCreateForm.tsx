import React from 'react';

import { Create, SimpleForm, Toolbar, SaveButton } from 'react-admin';
import { EntityCreateFields } from './EntityCreateFields';
import { entityLabel } from './EntityResource';

export const EntityCreateForm = props => (
  <Create {...props} title={'Create new ' + entityLabel}>
    <SimpleForm toolbar={<PostCreateToolbar />}>
      <EntityCreateFields />
    </SimpleForm>
  </Create>
);

const PostCreateToolbar = props => (
  <Toolbar {...props}>
    <SaveButton label="Create" redirect="list" submitOnEnter />
  </Toolbar>
);
