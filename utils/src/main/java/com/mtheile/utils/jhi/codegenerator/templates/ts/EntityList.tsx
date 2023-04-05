import React from 'react';
import { Datagrid, TextField, List, Filter, TextInput } from 'react-admin';
import { entityLabel } from './EntityResource';
import { entityDescription } from './EntityResource';

export const EntityList = props => (
  <>
    <List exporter={false} {...props} filters={<ListFilters />} title={entityLabel}>
      <Datagrid rowClick="edit">
        <TextField label={entityLabel} source="name" />
        <TextField label={entityDescription} source="description" />
      </Datagrid>
    </List>
  </>
);

const ListFilters = props => (
  <Filter {...props}>
    <TextInput label="Search" source="name" defaultValue="" alwaysOn />
  </Filter>
);
