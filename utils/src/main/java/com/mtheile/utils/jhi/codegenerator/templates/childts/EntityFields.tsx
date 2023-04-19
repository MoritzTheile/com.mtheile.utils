import React, { FC } from 'react';
import { AutocompleteInput, ReferenceInput, TextInput } from 'react-admin';
import { Grid } from '@material-ui/core';
import { AutocompleteInputWrapper } from 'app/litho-ui/mydata/crudentities/_shared/FieldWrapper';
import { makeStyles } from '@material-ui/core/styles';
import { EntityFieldsProps } from 'app/litho-ui/mydata/resources/_shared/EntityFieldsProps';
import resources from 'app/litho-ui/mydata/resources/resources';

export const composeEntityFields = (createMode: boolean): FC<EntityFieldsProps> => (props: EntityFieldsProps) => {
  const classes = useStyles();
  return (
    <>
      <TextInput variant="outlined" inputProps={{ autocomplete: 'off' }} source="description" />
			{/*{<!-- CODEGENERATOR_NEEDLE_FOR_ADDING_FIELDS (don't remove) -->}*/}
     
    </>
  );
};

const useStyles = makeStyles({
  hide: {
    display: 'none'
  }
});
