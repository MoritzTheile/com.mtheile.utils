import * as React from 'react';
import { getEntityPicker } from 'app/litho-ui/mydata/shared/datapointcomponents/EntityPicker';
import { entity2Shortname, entityDescription, entityLabel, entityResourceName, searchterm2query } from './EntityResource';

interface EntityPickerProps {
  dtoIdPath: string;
}

export const EntityPicker = (props: EntityPickerProps) =>
  getEntityPicker(entityLabel, props.dtoIdPath, entityResourceName, entity2Shortname, searchterm2query, entityDescription);
