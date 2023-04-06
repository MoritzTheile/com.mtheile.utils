import * as React from 'react';
import { Resource } from 'react-admin';
import { EntityList } from './EntityList';
import { EntityEdit } from './EntityEdit';
import { EntityCreateForm } from './EntityCreateForm';

export const entityResourceName = 'MODELNAME_TOKEN/ENTITYNAME_TOKEN';

export const entityLabel = 'ENTITYNAME_TOKEN';

export const entityDescription = '';

export const entity2Shortname = data => (data && data.id != null ? `${data.name}` : '');

export const searchterm2query = q => ({ plain: { 'name.contains': q, sort: 'sortorder' } });

export const ENTITYNAME_TOKENRAResource = (
  <Resource name={entityResourceName} list={EntityList} edit={EntityEdit} create={EntityCreateForm} />
);
