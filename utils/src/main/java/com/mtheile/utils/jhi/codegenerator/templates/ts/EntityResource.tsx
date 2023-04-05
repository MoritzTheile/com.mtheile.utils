import * as React from 'react';
import { Resource } from 'react-admin';
import resources from 'app/litho-ui/mydata/resources/resources';
import { EntityList } from './EntityList';
import { EntityEdit } from './EntityEdit';
import { EntityCreateForm } from './EntityCreateForm';

export const entityResourceName = resources.lHeAliquotType;

export const entityLabel = 'Aliquot Type';

export const entityDescription = 'The type of aliquot analysed, i.e., single-grain, multi-grain or unknown';

export const entity2Shortname = data => (data && data.id != null ? `${data.name}` : '');

export const searchterm2query = q => ({ plain: { 'name.contains': q, sort: 'sortorder' } });

export const LHeAliquotTypeRAResource = (
  <Resource name={entityResourceName} list={EntityList} edit={EntityEdit} create={EntityCreateForm} />
);
